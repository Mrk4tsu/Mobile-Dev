# 63CNTT-Mobile-Dev: LẬP TRÌNH ỨNG DỤNG MOBILE
> Sinh viên: Nguyễn Đức Thắng 63 CNTT-CLC 2
 ## Install:
 - Android Studio
 - Android 7.0 (Nougat API 24)
 - Java SE Development Kit (8u77)

 ***Quá trình thực hiện bài tập***
 ### BMI Caculator (Giao diện) - Đã cải thiện
 ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160140600058847282/image.png?ex=65339421&is=65211f21&hm=4f2c422061ece9b68f90acb8438d16cf736a53a88eb8cd02cd5f5c0214436695&)

  # Sử dụng layout
  - Sử dụng TextView + EditText
  ![image](https://media.discordapp.net/attachments/1023849047045447700/1154044897104494642/image.png?width=820&height=567)

  # Nâng cấp layout
  - Custom lại EditText
  ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160141674555650088/image.png?ex=65339521&is=65212021&hm=2044be9e95e2363482ce85888a56cf365024398890ee955aad09cd18fd0ef06f&)
  - Thêm icon minh họa sinh động
  ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160141973160726589/image.png?ex=65339568&is=65212068&hm=c387bc801be1c01179042198dacafbe9d157a8ba7edad3e3a3849070bea7b115&)
  - Thêm xử lý sự kiện
    *Sự kiện nếu người dùng nhập thiếu thông tin*
    ```java
    editTextHeight.getText().toString().isEmpty()
    ```
    Kiểm tra **isEmpty()** thì sẽ hủy tính toán, khi đó 1 toast sẽ hiển thị thông báo cho người dùng biết
  ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160143155337908264/image.png?ex=65339682&is=65212182&hm=7e95ae96e01f0c1bdb7ea55a0751d41ce9ebddb644970e7af8c1831c46e79cab&)
   *Sự kiện chuyển đổi dữ liệu qua radio button*
    

 ***Kết quả sẽ được:***

  ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1154045288487592037/image.png)

  - Để xem các phần phía dưới, ta sử dụng 1 ***ScrollView***
