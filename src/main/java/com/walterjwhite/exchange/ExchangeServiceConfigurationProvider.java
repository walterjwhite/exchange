package com.walterjwhite.exchange;

import com.walterjwhite.email.api.model.PrivateEmailAccount;
import com.walterjwhite.exchange.api.model.ExchangeService;
import com.walterjwhite.exchange.api.model.ExchangeServiceConfiguration;
import com.walterjwhite.exchange.property.ExchangeServiceUserId;
import com.walterjwhite.property.impl.annotation.Property;
import javax.inject.Provider;

// TODO: write this properly
public class ExchangeServiceConfigurationProvider
    implements Provider<ExchangeServiceConfiguration> {
  protected final ExchangeServiceConfiguration exchangeServiceConfiguration;

  public ExchangeServiceConfigurationProvider(
      @Property(ExchangeServiceUserId.class) final String exchangeUserId) {
    super();

    // lookup by exchangeUserId
    PrivateEmailAccount privateEmailAccount = null;
    ExchangeService exchangeService = null;
    this.exchangeServiceConfiguration = null;
    //        new ExchangeServiceConfiguration(privateEmailAccount, exchangeService);
  }

  @Override
  public ExchangeServiceConfiguration get() {
    return (exchangeServiceConfiguration);
  }
}
