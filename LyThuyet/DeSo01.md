a) Ngắt lập tức do không tìm thấy host và port tương ứng. <br />
b) Chạy vĩnh viễn đến khi kết thúc phiên/Client chủ động ngắt. <br />
c) b khác a là Client vẫn hoạt động còn ở a thì Client báo lỗi do trong giao thức UDP, client và server hoạt động độc lập, UDP truyền gói tin đi nhưng không đợi gói tin nhận về từ Server. Còn trong giao thức TCP thì Client/Server phải xác lập kết nối Socket ngay bước đầu tiên. <br />
