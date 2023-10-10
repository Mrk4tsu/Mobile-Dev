# 63CNTT-Mobile-Dev: LẬP TRÌNH ỨNG DỤNG MOBILE
> Sinh viên: Nguyễn Đức Thắng 63 CNTT-CLC 2
 ## Install:
 - Android Studio
 - Android 7.0 (Nougat API 24)
 - Java SE Development Kit (8u77)

***Quá trình thực hiện bài tập***
### Update 10/7 - Thêm xử lý sự kiện, Chỉnh sửa design UI
![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160995256079237170/image.png?ex=6536b017&is=65243b17&hm=6858cae24bc308696d9969cc70d2acac9043efcc4fd89c6e9823cfa1c9d30a6e&)

### Xử lý sự kiện, giao diện thay đổi kích thước của chữ
#### DEMO:
![image](https://github.com/Mrk4tsu/Mobile-Dev/blob/exno1/Preview/exno1_1.gif)

### Tiến trình:
* Custom card hiển thị thông tin

#### Card 1 (Panel Gradient)
```xml
<shape
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <gradient android:startColor="#FCE38A" android:endColor="#F38181"/>
    <corners android:radius="20dp"/>
</shape>
```

 #### Card 2 (Panel)
```xml
<shape
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="#323538"/>
    <corners android:radius="20dp"/>
</shape>
```

* Custom Button
```xml
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!--    Chưa bấm-->
    <item android:state_pressed="false">
        <shape android:shape="rectangle">
            <solid android:color="@color/grey" />
            <corners android:radius="40dp"/>
        </shape>
    </item>
    <!--    Khi bấm vào-->
    <item android:state_pressed="true">
        <shape android:shape="rectangle">
            <solid android:color="@color/color_hint" />
            <corners android:radius="40dp"/>
        </shape>
    </item>
</selector>
```
- Sử dụng **selector** để thực hiện custom.
- Trong đó 2 **item**, 1 **item** thể hiện *state_pressed = "false"* hiển thị khi người dùng không tác động vào, 1 **item** thể hiện *state_pressed = "true"* hiển thị khi người dùng bấm vào.
- Các thuộc tính **solid: cài đặt màu nền** và **corner: cài đặt bo viền**.
- Thay thế **background** bằng file xml vừa custom.

* Code xử lý sự kiện
```java
float fontSize = 24;

btnAddSizeFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labelFontSize.setTextSize(fontSize + 1);
                fontSize += 1;
                if (fontSize == 40)
                    fontSize = 24;
                inputSizeFont.setText(String.valueOf(fontSize));
            }
        });
```

- Khởi tạo 1 biến float *fontSize* để lưu trữ size của *labelFontSize*.
- Sự kiện khi ấn vào button **+**, font size của *labelFontSize* sẽ tăng lên 1 và đồng thời sẽ cập nhật thêm ở *fontSize += 1*.
- Giới hạn người dùng tăng size tới 40 thì sẽ reset về size ban đầu (*ở đây sẽ trở về 24*)
- Nút **-** cũng thao tác tương tự

```java
public void onClick(View view) {
                String getSizeFont = inputSizeFont.getText().toString();
                if (getSizeFont.isEmpty()) {
                    fontSize = 20;
                    labelFontSize.setTextSize(fontSize);
                    return;
                }
                float size = Float.parseFloat(getSizeFont);
                if (size > 40) {
                    size = 20;
                    Toast.makeText(MainActivity.this, "Số quá lớn", Toast.LENGTH_SHORT).show();
                    return;
                }
                labelFontSize.setTextSize(size);
            }
```

- Cho người dùng nhập vào 1 size bất kì.
- Biến *getSizeFont* sẽ lấy và lưu trữ thông tin của người dùng nhập vào.
- **getSizeFont.isEmpty()** kiểm tra nếu người dùng không nhập gì thì *labelFontSize* có size là 20.
- Nếu người dùng nhập size > 40, size *labelFontSize* cũng sẽ tự chuyển về 20 và thông báo cho người dùng.
- Nếu người dùng nhập đúng điều kiện sẽ chuyển đổi kích thước đúng theo người dùng nhập vào.


