package com.walterjwhite.exchange.api.model;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import com.walterjwhite.email.api.model.EmailAccount;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExchangeServiceConfiguration extends AbstractNamedEntity {
  @ManyToOne @JoinColumn protected EmailAccount emailAccount;
  @ManyToOne @JoinColumn protected ExchangeService exchangeService;

  public ExchangeServiceConfiguration() {
    super();
  }

  public EmailAccount getEmailAccount() {
    return emailAccount;
  }

  public void setEmailAccount(EmailAccount emailAccount) {
    this.emailAccount = emailAccount;
  }

  public ExchangeService getExchangeService() {
    return exchangeService;
  }

  public void setExchangeService(ExchangeService exchangeService) {
    this.exchangeService = exchangeService;
  }
}
