package jdbc_hikaricp.service;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_hikaricp.AbstractTest;
import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionServiceTest extends AbstractTest {
	private static TransactionService service = TransactionService.getInstance();

	@Test(expected = RuntimeException.class)
	public void test1InsertTitleDept() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title(); // 에러
		title.setTitleCode(1);
		title.setTitleName("사원");
		Department department = new Department(6, "H/W개발", 6);
		service.addTitleDeparment(title, department);
	}

	@Test(expected = RuntimeException.class)
	public void test2InsertTitleDept() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleCode(6);
		title.setTitleName("무기계약");
		Department department = new Department(1, "개발", 6);// 에러
		service.addTitleDeparment(title, department);
	}

	@Test
	public void test3InsertTitleDept() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleCode(6);
		title.setTitleName("무기계약");
		Department department = new Department(6, "H/W개발", 6);
		service.addTitleDeparment(title, department);
	}


	@Test(expected = RuntimeException.class)
	public void test4DeleteTitleDept() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title(); // fail
		title.setTitleCode(8);
		title.setTitleName("사원");
		Department department = new Department(6, "H/W개발", 6);
		service.removeTitleDeparment(title, department);
	}

	@Test(expected = RuntimeException.class)
	public void test5DeleteTitleDept() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleCode(7);
		title.setTitleName("무기계약");
		Department department = new Department(10, "개발", 6);// fail
		
		service.removeTitleDeparment(title, department);
	}

	@Test
	public void test6DeleteTitleDept() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleCode(7);
		title.setTitleName("무기계약");
		Department department = new Department(6, "H/W개발", 6);
		service.removeTitleDeparment(title, department);
	}

}
