package com.walterjwhite.exchange;

import com.walterjwhite.datastore.api.model.entity.Tag;
import microsoft.exchange.webservices.data.property.complex.FolderId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExchangeUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeUtils.class);

  private ExchangeUtils() {}

  public static Tag getLabel(FolderId folderId, Tag parent) {
    Tag label = null;
    if (folderId != null && folderId.getFolderName() != null) {
      label = new Tag(folderId.getFolderName().toString(), parent);

      LOGGER.info("label:" + label.getName());
      if (label.getParent() != null) {
        LOGGER.info("label parent:" + label.getParent().getName());
      }
    }

    return (label);
  }
}
