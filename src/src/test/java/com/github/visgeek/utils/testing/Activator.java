package com.github.visgeek.utils.testing;

import java.lang.reflect.Constructor;

public class Activator {
	private Activator() {
		throw new RuntimeException();
	}

	static {
		Activator.create(Activator.class);
	}

	public static void create(Class<?> target) {
		try {
			Constructor<?> ctor = target.getDeclaredConstructor();
			ctor.setAccessible(true);
			ctor.newInstance();
		} catch (Exception e) {
		  //
		}
	}
}
