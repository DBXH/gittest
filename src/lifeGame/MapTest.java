package lifeGame;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {
	private static Map map=new Map();
	private static Cell [][]cell=new Cell[16][16];
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cell=map.initial();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		;
	}

	@Test
	public void testGetLiving() {
		//先设置所有细胞存活
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(1);
			}
		}
		//分别得到整个地图中所有细胞周围活细胞数目
		map.getLiving(cell);
		//检验不同位置的细胞周围活细胞数目与预期结果是否相同
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				if(i>0&&i<15&&j>0&&j<15) assertEquals(8,cell[i][j].getLiving());
				else if((i==0||i==15)&&(j>0&&j<15)||(j==0||j==15)&&(i>0&&i<15)) assertEquals(5,cell[i][j].getLiving());
				else assertEquals(3,cell[i][j].getLiving());
			}
		}
		//再设置所有细胞死亡
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getLiving(cell);
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				assertEquals(0,cell[i][j].getLiving());
			}
		}
	}

	@Test
	public void testUpdate() {
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(1);
			}
		}
		map.getLiving(cell);
		//检验活细胞数量与预期是否相同
		assertEquals(4,map.update(cell));
		
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getLiving(cell);
		assertEquals(256,map.update(cell));
	}

}

