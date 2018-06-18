package com.leon.dand.annotaction;

import java.lang.annotation.*;

@Documented
@Target(value={ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Action
{
	String value();
}
