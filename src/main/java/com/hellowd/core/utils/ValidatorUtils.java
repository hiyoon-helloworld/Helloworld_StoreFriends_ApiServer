/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.sf.oval.ConstraintViolation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ValidatorUtils {

	private static net.sf.oval.Validator validator = new net.sf.oval.Validator();

	/**
	 * 파라미터명, 파라미터값, 파라미터 검증을 위한 지연 로직(predicate)을 포함하는 완전한 TestTuple4이다.
	 */
	@AllArgsConstructor
	@Data
	public static class TestTuple4<T> {
		protected String name;
		protected T value;
		protected Predicate<T> predicate;
		private String cause;
		
		public boolean test() { return predicate.test(value); }
		
		@Override
		public String toString() { return "TestTuple4[name="+name+", value="+value+", cause="+cause+"]"; }
	}
	
	/**
	 * String 타입의 파라미터에 대해서 empryOrNull확인을 위해 기본적으로 StringUtils.isNotEmpty() 메소드를 사용하는 predicate를 제공한다.
	 */
	public static TestTuple4<String> testTuple(String name, String value) {
		return new TestTuple4<>(name, value, StringUtils::isNotEmpty, null);
	}
	
	/**
	 * String 타입을 제외한 제네릭 파라미터에 대해서 empryOrNull확인을 위해 기본적으로 null 확인  predicate를 제공한다.
	 */
	public static <T> TestTuple4<T> testTuple(String name, T value) {
		return new TestTuple4<>(name, value, Objects::nonNull, null);
	}

	public static <T> TestTuple4<T> testTuple(String name, T value, Predicate<T> predicate) {
		return new TestTuple4<>(name, value, predicate, null);
	}

	public static <T> TestTuple4<T> testTuple(String name, T value, Predicate<T> predicate, String cause) {
		return new TestTuple4<>(name, value, predicate, cause);
	}
	
	/**
	 * OVal 애노테이션에 기반하여 객체에 대해 validation을 수행한다.
	 */
	public static <T, V> void throwIfInvalid(Class<T> claz, V obj) throws IllegalArgumentException {
		List<ConstraintViolation> errors = validator.validate(obj);
		if (errors != null && errors.size() > 0)
			throw new IllegalArgumentException(String.format("Invalid object `%s` parameter (cause: %s)",
					claz.getSimpleName(), errors.get(0).getMessage()));
	}

	/**
	 * 제네릭 타입의 파라미터에 대해서는 validation 수행을 위해 개별적 predicate를 제공해야 한다.
	 */
	public static <T> void throwIfInvalid(String name, T value, Predicate<T> predicate) throws IllegalArgumentException {
		throwIfInvalid(testTuple(name, value, predicate));
	}

	/**
	 * 제네릭 타입의 파라미터에 대해서는 validation 수행을 위해 개별적 predicate를 제공해야 한다.
	 */
	public static <T> void throwIfInvalid(String name, T value, Predicate<T> predicate, String cause) throws IllegalArgumentException {
		throwIfInvalid(testTuple(name, value, predicate, cause));
	}
	
	public static <T> void throwIfInvalid(TestTuple4<T> tuple4) throws IllegalArgumentException {
		if (!tuple4.test()) {
			if (tuple4.cause == null)
				throw new IllegalArgumentException(String.format("Invalid parameter `%s`", tuple4.name));
			else
				throw new IllegalArgumentException(String.format("Invalid parameter `%s` (cause: %s)", tuple4.name, tuple4.cause));
		}
	}

	@SuppressWarnings("rawtypes")
	public static void throwIfInvalid(TestTuple4... tuples) {
		for (TestTuple4 testTuple4 : tuples)
			ValidatorUtils.throwIfInvalid(testTuple4);
	}

	/**
	 * String 타입의 파라미터에 대해서 empryOrNull확인을 위해 기본적으로 StringUtils.isNotEmpty() 메소드를 사용하는 predicate를 제공한다.
	 * String 타입에 대해 별도의 empryOrNull확인이 필요하면 predicate를 명시적으로 선언해야 한다.
	 */
	public static void throwIfEmptyOrNull(String name, String value) throws IllegalArgumentException {
		throwIfEmptyOrNull(testTuple(name, value));
	}

	/**
	 * String 타입을 제외한 제네릭 파라미터에 대해서 empryOrNull확인을 위해 기본적으로 null 확인 predicate를 제공한다.
	 * String 타입을 제외한 제네릭 파라미터에 대해 별도의 empryOrNull확인이 필요하면 predicate를 명시적으로 선언해야 한다.
	 */
	public static <T> void throwIfEmptyOrNull(String name, T value) throws IllegalArgumentException {
		throwIfEmptyOrNull(testTuple(name, value));
	}

	/**
	 * 파라미터의 empryOrNull 확인을 위해 명시적 predicate를 제공한다.
	 */
	public static <T> void throwIfEmptyOrNull(String name, T value, Predicate<T> predicate) throws IllegalArgumentException {
		throwIfEmptyOrNull(testTuple(name, value, predicate));
	}

	public static <T> void throwIfEmptyOrNull(TestTuple4<T> tuple4) throws IllegalArgumentException {
		if (!tuple4.test())
			throw new IllegalArgumentException(String.format("Mandatory parameter `%s` missing", tuple4.name));
	}
	
	@SuppressWarnings("rawtypes")
	public static void throwIfEmptyOrNull(TestTuple4... tuples) throws IllegalArgumentException {
		for (TestTuple4 testTuple4 : tuples)
			ValidatorUtils.throwIfEmptyOrNull(testTuple4);
	}

}
