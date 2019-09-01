package com.walterjwhite.exchange.api.model;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(doNotUseGetters = true, callSuper = true)
// @PersistenceCapable
public class ExchangeServiceConfiguration extends AbstractNamedEntity {

  public ExchangeServiceConfiguration() {
    super();
  }
}
