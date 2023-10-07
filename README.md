# 63CNTT-Mobile-Dev: LẬP TRÌNH ỨNG DỤNG MOBILE
> Sinh viên: Nguyễn Đức Thắng 63 CNTT-CLC 2
 ## Install:
 - Android Studio
 - Android 7.0 (Nougat API 24)
 - Java SE Development Kit (8u77)

 ***Quá trình thực hiện bài tập***
 ### BMI Caculator (Giao diện) - Đã cải thiện
 ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160140600058847282/image.png?ex=65339421&is=65211f21&hm=4f2c422061ece9b68f90acb8438d16cf736a53a88eb8cd02cd5f5c0214436695&)
  # Nâng cấp layout
  - Custom lại EditText
  ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160141674555650088/image.png?ex=65339521&is=65212021&hm=2044be9e95e2363482ce85888a56cf365024398890ee955aad09cd18fd0ef06f&)
  - Thêm icon minh họa sinh động
  ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160141973160726589/image.png?ex=65339568&is=65212068&hm=c387bc801be1c01179042198dacafbe9d157a8ba7edad3e3a3849070bea7b115&)
  - Thêm xử lý sự kiện
    *Sự kiện button chọn giới tính*
    ```java
        void chooseSexual() {
        sexual_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_sexual.setText("giới tính: NAM".toUpperCase());
            }
        });
        sexual_woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_sexual.setText("giới tính: NỮ".toUpperCase());
            }
        });
    }
    ```
    ***Khi người dùng click vào button giới tính, dòng hiển thị giới tính sẽ in ra màn hình giới tính mà người dùng đã chọn***
   ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160148667508981821/image.png?ex=65339ba4&is=652126a4&hm=aba4c87e9d23d28b97df9f397207f9b91f332b3a4bf1a8fbd9acc386691d7956&)
    
    *Sự kiện nếu người dùng nhập thiếu thông tin*
    ```java
    editTextHeight.getText().toString().isEmpty()
    ```
    Kiểm tra **isEmpty()** thì sẽ hủy tính toán, khi đó 1 toast sẽ hiển thị thông báo cho người dùng biết
  ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160143155337908264/image.png?ex=65339682&is=65212182&hm=7e95ae96e01f0c1bdb7ea55a0751d41ce9ebddb644970e7af8c1831c46e79cab&)

   *Sự kiện chuyển đổi dữ liệu qua radio button*
    ```java
    void checkChangeRadioButton() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.unit_inch) {
                    editTextHeight.setHint("NHẬP CHIỀU CAO (INCH)".toUpperCase());
                    editTextWeight.setHint("NHẬP CÂN NẶNG (pound)".toUpperCase());
                    unit_cm.setChecked(false);
                } else if (i == R.id.unit_cm) {
                    editTextHeight.setHint("NHẬP CHIỀU CAO (CM)".toUpperCase());
                    editTextWeight.setHint("NHẬP CÂN NẶNG (KG)".toUpperCase());
                    unit_inch.setChecked(false);
                }
            }
        });
    }
    ```
    ***Nếu chọn đơn vị chiều cao là INCH thì sẽ chuyển qua phương pháp tính INCH, ngược lại. Thực ra BMI sẽ cùng 1 công thức, tuy nhiên sẽ xử lý dữ liệu nhập vào***
    ***1 inch = 2.54 centimeters***
    ***1 pound = 0.45359237 kilograms***

    *Hiển thị kết quả cho người dùng*
   -Thêm mã màu khi hiển thị biểu hiện nghiêm trọng của chỉ số người dùng nhập vào
   ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160147741029175327/Layer_2.png?ex=65339ac7&is=652125c7&hm=3868b8b251be1001af23369a5fce239838c8c1dadd022bc7c9e5b1f24a0623b5&)
