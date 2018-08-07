package com.nalanhi.etc;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author beomhoon.jeong@vtw.co.kr
 * @date 2018. 4. 4.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class EventTest {

//	Events.raise();
}

enum UserState {
	USER, STORE, LEAVE;
}
