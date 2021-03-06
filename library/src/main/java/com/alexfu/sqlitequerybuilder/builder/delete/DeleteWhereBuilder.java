package com.alexfu.sqlitequerybuilder.builder.delete;

import com.alexfu.sqlitequerybuilder.api.Builder;
import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.builder.where.ClauseBuilder;

import static com.alexfu.sqlitequerybuilder.utils.StringUtils.join;

public class DeleteWhereBuilder extends SegmentBuilder {

  private Builder prefix;
  private ClauseBuilder condition;

  DeleteWhereBuilder(Builder prefix, ClauseBuilder condition) {
    this.condition = condition;
    this.prefix = prefix;
  }

  @Override
  public String build() {
    return join(" ", prefix.build(), "WHERE", condition.build());
  }
}
