package com.walterjwhite.exchange.api.model;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ExchangeService extends AbstractNamedEntity {
  @Column(nullable = false)
  protected String exchangeVersion;

  @Column(nullable = false)
  protected String uri;

  public String getExchangeVersion() {
    return exchangeVersion;
  }

  public void setExchangeVersion(String exchangeVersion) {
    this.exchangeVersion = exchangeVersion;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }
}
