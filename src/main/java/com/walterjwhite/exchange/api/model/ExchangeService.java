package com.walterjwhite.exchange.api.model;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(doNotUseGetters = true, callSuper = true)
// @PersistenceCapable
@Entity
public class ExchangeService extends AbstractNamedEntity {
  @Column(nullable = false)
  protected String exchangeVersion;

  @Column(nullable = false)
  protected String uri;
}
