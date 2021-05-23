# Đề tài môn Công nghệ phần mềm
### Tên đề tài :App kiểm tra sức khỏe hằng ngày
### Nhóm thực hiện: 25
## Danh sách các yêu cầu của đề tài:

#### 1. Khảo sát yêu cầu khách hàng.
#### Design Pattern: Sử dụng design pattern MVP.

#### Project v1.0 nộp lần đầu 15/04/2021
######	Mức độ hoàn thành đồ án 40%
	1. Các cấu trúc đều theo dạng MVP.
	2. Hoàn thành đa phần View.
	3. Các fragment dành cho các chức năng của menu đều được kế thừa từ 1 fragment, dễ sửa chữa.
	4. Presenter chỉ mới làm phần Login là chính, các phần khác vẫn còn trống.
	5. Model đã khởi tạo demo, 2 class MongoDB (dành cho kết nối onl) và SQLite (local)
	6. Chưa tạo Database để kết nối.
######  Hướng dẫn sử dụng v1.0:
	1. đăng nhập với tài khoản username: admin, password: 123, sẽ được chuyển sang trang menu
	2. Tất cả chức năng đều mở được trừ news, watch và doctor.
	3. Nhấn nút back để trả về trang chủ, hoặc nhấn nút icon ở trên trái màn hình.
######  Hướng dẫn sử dụng v2.0:
	1. Đăng nhập với tài khoản username: admin, password: 123, sẽ được chuyển sang trang menu
	2. Mỗi chức năng hiện tại đều có các trường nhập, các nút thêm, xóa, sửa, tư vấn (?) bảng dữ liệu, nút lưu và nút thống kê.
	3. Mọi lần thêm dữ liệu thì nhớ nhấn nút SAVE để lưu dữ liệu lại, nút thống kê sẽ điều hướng tới bảng thống kê dựa trên dữ liệu đã nhập.
	4. Chức năng YOUR HEART dùng để kiểm soát tim mạch, nhập 2 trường Heart Rate và Heart Pressure, sau đó bấm dấu cộng để 1 bản ghi dữ liệu, bản ghi sau khi được thêm vào được đánh giá dựa trên dữ liệu nhập và có thể được chọn để sửa, xóa, xem tư vấn, nhấn SAVE để lưu lại không thì sẽ mất dữ liệu.
	5. Chức năng BODY INFO dùng kiểm soát chiều cao và cân nặng,  nhập 2 trường cân nặng và chiều cao, mọi việc còn lại giống như chức năng YOUR HEART.
	6. Chức năng CONTROL CALORIES dùng kiểm soát lượng calo nạp vào và tiêu thụ,  nhập 2 trường nạp vào và đốt cháy, mọi việc còn lại giống như chức năng YOUR HEART.
	7. Chức năng CONTROL FOOD dùng để tính lượng calo đã nạp vào cơ thể, nhập những gì mình đã ăn, sau đó bấm TÌM KIẾM để tính kết quả ra calo, bấm CHUYỂN KẾT QUẢ VÀO CALO để lưu dữ liệu gần nhất, bấm XÓA DỮ LIỆU CHUYỂN để bỏ dữ liệu lưu trữ.
	8. Chức năng DO EXERCISE dùng để tính lượng calo đã đốt cháy nhờ ,  nhập những gì mình tập trong bao lâu, mọi việc còn lại giống như chức năng CONTROL FOOD.
	9. Chức năng CONTROL BREATHE dùng kiểm tra tình trạng phổi, nhập xem mình nín thở được bao lâu, mọi việc còn lại giống như chức năng YOUR HEART.
	10. Chức năng CONTROL PHONE dùng kiểm soát thời lượng,  nhập số giờ dùng điện thoại, mọi việc còn lại giống như chức năng YOUR HEART.
	11. Chức năng News, Doctor, Watch, Period và Sleep chưa hoàn thiện.
