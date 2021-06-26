package lifeGame;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellTest {
    private static Cell cell=new Cell();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		;
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		;
	}
	@Test
	public void testUpdateStatus() {
		//设置不同当前细胞周围活细胞数，再检验演化后与预期结果是否相同
		cell.setLiving(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		cell.setLiving(3);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());
		cell.setLiving(4);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		cell.setStatus(1);
		cell.setLiving(2);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());
	}

}

