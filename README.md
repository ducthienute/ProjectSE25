# Đề tài môn Công nghệ phần mềm

## Tên đề tài :App kiểm tra sức khỏe hằng ngày

## Nhóm thực hiện: 25

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

######  Hướng dẫn sử dụng v3.0:
	1. Mới cài app về sẽ ở trang cá nhân để tạo tài khoản với tên đăng nhập, mật khẩu số, ngày sinh và giới tính, sau đó nhấn nút "Trở về ứng dụng" để lưu thông tin lại, sau đó hệ thống chuyển hướng trang đăng nhập, nhập mật khẩu để nhấn "Xác nhận" để vào trang chủ.
	2. Có 12 chức năng đối với tài khoản nam, 13 đối với tài khoản nữ.
	3. Nút tim trên cùng bên trái hoạt động như nút quay về trang trước, nhưng ở trang chủ sẽ không chuyển đi đâu cả.
	4. Nút ốc vít bên phải sẽ chuyển hướng tới trang thông tin cá nhân để chỉnh sửa thông tin cá nhân, nếu không chỉnh sửa thì có thể quay về bằng nút "Trở về ứng dụng", nếu có chỉnh sửa và bấm nút "Trở về ứng dụng" sẽ lưu thông tin và tự chuyển hướng về trang đăng nhập, còn nếu muốn đăng xuất không chỉnh sửa thì nhấn nút "Đăng xuất".
	5. Ở trang đăng nhập nếu nhấn "Xác nhận" sai 5 lần sẽ tự động chuyển hướng tới trang cá nhân để tạo tài khoản mới.
	6. Chức năng News để đọc tin tức mới nhất của các bài viết về sức khỏe ở trang web suckhoedoisong.vn, nhấn vào sẽ hiện bảng chọn trình duyệt, chọn trình duyệt và hệ thống sẽ chuyển hướng đến trình duyệt đó.
	7. Chức năng Smart Watch chưa hoàn thiện.
	8. Chức năng Contact Doctor để hiện ra danh sách các bác sĩ có thể liên lạc được, có thể chọn để gọi bằng Zalo.
	9. Chức năng Heart Care để kiểm tra sức khỏe tim mạch, nhập thông tin nhịp tim và áp suất tim, nút đánh giá để đưa ra đánh giá về dữ liệu đã nhập, nút lưu bên trái để lưu dữ liệu vào danh sách, lướt qua trái là bảng dữ liệu, mỗi mẫu dữ liệu có màu khác nhau dựa trên dữ liệu được đánh giá, có nút đánh giá hình kính lúp để xem các lời khuyên dựa vào tình trạng của mẫu dữ liệu đó, có thể chọn một hoặc nhiều mẫu dữ liệu sẽ chuyển màu xanh ngọc khi được chọn, có thể dùng nút xóa để xóa 1 hoặc hàng loạt mẫu dữ liệu, thống kê để đến bảng thống kê các dữ liệu được chọn. Nút chỉnh sửa chỉ sửa được 1 lúc 1 mẫu dữ liệu, nếu chọn nhiều mẫu sẽ chỉnh sửa mẫu cuối cùng. Chức năng đồ thị sẽ vẽ biểu đồ dựa trên dữ liệu được nhập, có nút đánh "Đánh giá" để xem để đánh giá tổng quan về biểu đồ. Trên biểu đồ có thể phóng to, thu nhỏ, có chú thích các đường ở góc dưới trái, nút hình 4 mũi tên để resize đồ thị về kích cỡ mặc định, nút "Đổi biểu đồ" để chuyển sang biểu đồ khác nếu có nhiều mục chức năng.
	10. Chức năng Breath Care dùng để kiểm soát tình trạng lá phổi, bấm vào khung thêm mẫu để kích hoạt đồng hồ bấm giờ nín thở, chạm màn hình lần nữa để dừng đồng hồ, các nút "Lưu" và "Đánh giá", bảng dữ liệu và đồ thị giống như chức năng Heart Care.
	11. Chức năng BMI để kiểm soát chỉ số khối cơ thể bằng cân nặng và chiều cao, nhập chiều cao (cm) và cân nặng (kg), sau đó các chức năng còn lại giống như chức năng Heart Care.
	12. Chức năng Food Search để tính lượng calo đã nạp vào cơ thể, nhập những gì mình đã ăn bằng tiếng Anh vào ô nhập, sau đó nhấn "Yêu cầu để tính số calo ở kết quả, bấm "Thêm dữ liệu vào bảng tạm" để lưu dẽ liệu dùng trong chức năng Giám sát calo, có thể xóa bằng nút "Xóa dữ liệu".
	13. Chức năng Exercise Search để tính lượng calo đã đốt nhờ tập luyện, nhập những hoạt động đã thực hiện bằng tiếng Anh vào ô nhập, sau đó nhấn "Yêu cầu để tính số calo ở kết quả, bấm "Thêm dữ liệu vào bảng tạm" để lưu dẽ liệu dùng trong chức năng Giám sát calo, có thể xóa bằng nút "Xóa dữ liệu".
	14. Chức năng Calories Care để kiểm soát lượng calo ra/vào cơ thể, có thể nhập tay hoặc dùng chức năng Food Search và Exercise Search để có dữ liệu nếu không biết tính, mọi chức năng con còn lại giống như chức năng Heart Care.
	15. Chức năng Phone Control để kiểm soát thời lượng sử dụng điện thoại, nhập số giờ đã sử dụng điện thoại, sau đó mọi chức năng con giống như chức năng Heart Care.
	16. Chức năng Sleep Care để kiểm soát thời lượng giấc ngủ, nhập thời gian đi ngủ, thời gian tỉnh dậy, sau đó mọi chức năng con giống như chức năng Heart Care.
	17. Chức năng nhắc sinh nhật để đếm ngược số ngày tới sinh nhật của bạn, nếu ngày đó là sinh nhật bạn thì hệ thống sẽ gửi lời chúc mừng đến bạn.
	18. Nếu bạn là nữ thì sẽ có thêm chức năng Period Care để kiểm soát chu kỳ kinh nguyệt của bạn, nhập ngày gần nhất xuất hiện kinh nguyệt, sau đó mọi chức năng con giống như chức năng Heart Care.
	19. Để tạo bộ dữ liệu thử nghiệm thì bạn ra trang chủ, nhấn nút quay lại trên điện thoại 10 lần, sau đó OK.
	20. Ứng dụng hỗ trợ 3 ngôn ngữ: tiếng Anh, tiếng Việt và tiếng Đức. Khi bạn thay đổi vùng và ngôn ngữ của điện thoại là Việt Nam ngôn ngữ của ứng dụng sẽ là tiếng Việt, tương tự với vùng và ngôn ngữ điện thoại là Đức thì ngôn ngữ ứng dụng là tiếng Đức, mọi vùng và ngôn ngữ còn lại thì ứng dụng sẽ hiển thị tiếng Anh.

