package com.integrallis.modernjee.seam.bookstore.logic.service;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Unwrap;

import com.integrallis.modernjee.seam.bookstore.util.PigLatinWithATwist;

@Name("pigLatinService")
public class PigLatinService {
	PigLatinWithATwist pigLatin;
	
	@Unwrap
	public PigLatinWithATwist getMyPig() {
		if (pigLatin == null) {
			pigLatin = new PigLatinWithATwist();
		}
		return pigLatin;
	}
}
