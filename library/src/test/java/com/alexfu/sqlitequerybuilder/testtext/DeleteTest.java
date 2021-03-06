package com.alexfu.sqlitequerybuilder.testtext;

import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;
import org.junit.Test;

import static com.alexfu.sqlitequerybuilder.api.SQLiteClauseBuilder.clause;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alexfu on 7/7/15.
 */
public class DeleteTest {
  @Test
  public void testDeleteAll() {
    String sql = SQLiteQueryBuilder
      .delete()
      .from("my_table")
      .build();

    assertThat(sql).isEqualTo("DELETE FROM my_table");
  }

  @Test
  public void testDeleteWhere() {
    String sql = SQLiteQueryBuilder
      .delete()
      .from("my_table")
      .where(clause("id = 1"))
      .build();

    assertThat(sql).isEqualTo("DELETE FROM my_table WHERE id = 1");
  }
}
