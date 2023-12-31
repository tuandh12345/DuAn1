package nhom2.test.thang;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Model.KhachHangModel;

public class XoaKH {
	KhachHangModel model = new KhachHangModel();
	KhachHangDAO dao = new KhachHangDAO();


	@Test
	public void testDelete() {
		KhachHangModel model = new KhachHangModel();
		String maKH = null;
		model.setMaKH(maKH);
		String kq = "";
		String kqmd = "Bạn chưa chọn khách hàng để xóa";
		try {
			dao.delete(model);
			List<KhachHangModel> list = dao.selectMa(maKH);
			if (list.isEmpty()) {
				kq = "Bạn chưa chọn khách hàng để xóa";
			} else {
				kq = "Xóa thành công";
			}
			Assert.assertEquals(kqmd, kq);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
