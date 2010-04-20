package com.integrallis.modernjee.seam.bookstore.model;

import com.bm.datagen.Generator;
import com.bm.datagen.annotations.GeneratorType;
import com.bm.testsuite.BaseEntityFixture;

import com.integrallis.modernjee.seam.bookstore.model.Gender;
import com.integrallis.modernjee.seam.bookstore.model.Person;
import com.bm.datagen.Generator;
import com.bm.datagen.annotations.GeneratorType;
import com.bm.testsuite.BaseEntityFixture;

public class PersonDBTest extends BaseEntityFixture<Person> {

	private static final Generator[] SPECIAL_GENERATORS = { new MyGenderCreator() };

	public PersonDBTest() {
		super(Person.class, SPECIAL_GENERATORS);
	}
		
	@GeneratorType(className = Gender.class)
	private static final class MyGenderCreator implements Generator<Gender> {

		public Gender getValue() {
			return Gender.MALE;
		}

	}
}
