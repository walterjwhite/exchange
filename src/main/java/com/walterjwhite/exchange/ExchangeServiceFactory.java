package com.walterjwhite.exchange;

import com.walterjwhite.email.api.model.EmailAccount;
import javax.inject.Inject;
import javax.inject.Provider;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;

public class ExchangeServiceFactory implements Provider<ExchangeService> {
  private static final String EXCHANGE_SERVICE_URI_KEY = "ExchangeServiceURI";
  protected final ExchangeService exchangeService;

  @Inject
  public ExchangeServiceFactory(EmailAccount emailAccount) {
    super();
    exchangeService = new ExchangeService(getExchangeVersion(emailAccount));
    exchangeService.setCredentials(getExchangeCredentials(emailAccount));

    try {
      exchangeService.autodiscoverUrl(getExchangeServiceUri(emailAccount));
    } catch (Exception e) {
      throw (new RuntimeException("Error configuring exchange service:", e));
    }
  }

  protected ExchangeCredentials getExchangeCredentials(EmailAccount emailAccount) {
    return new WebCredentials(
        emailAccount.getUsername(), emailAccount.getPassword(), emailAccount.getDomain());
  }

  private static String getExchangeServiceUri(EmailAccount emailAccount) {
    return emailAccount.getProvider().getSettings().get(EXCHANGE_SERVICE_URI_KEY);
  }

  private static ExchangeVersion getExchangeVersion(EmailAccount emailAccount) {
    final String value =
        emailAccount.getProvider().getSettings().get(ExchangeVersion.class.getName());

    if (value == null || value.isEmpty()) {
      return (ExchangeVersion.Exchange2010_SP2);
    }

    return (ExchangeVersion.valueOf(value));
  }

  @Override
  public ExchangeService get() {
    return (exchangeService);
  }
}
