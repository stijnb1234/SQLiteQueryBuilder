package com.alexfu.sqlitequerybuilder.builder.select;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.Preconditions;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;

public class SelectFunctionBuilder extends SegmentBuilder {

	private SelectBuilder prefix;
	private FunctionType function;
	private String[] args;

	SelectFunctionBuilder(SelectBuilder prefix, FunctionType function, String... args) {
		Preconditions.checkArgument(function.argumentNumber.contains(args.length), "Argument list too long or short!");
		this.prefix = prefix;
		this.function = function;
		this.args = args.length != 0? args : new String[] {"*"};
	}

	public SelectFromBuilder from(String table) {
		Preconditions.checkArgument(table != null, "Table cannot be null");
		return new SelectFromBuilder(this, table);
	}

	@Override
	public String build() {
		return StringUtils.join(" ", prefix.build(),
				function.name + StringUtils.join(",", args) + ")");
	}
}
