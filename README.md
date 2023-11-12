# 63CNTT-Mobile-Dev: LẬP TRÌNH ỨNG DỤNG MOBILE
> Sinh viên: Nguyễn Đức Thắng 63 CNTT-CLC 2
 ## Install:
 - Android Studio
 - Android 7.0 (Nougat API 24)
 - Java SE Development Kit (8u77)

 ***Quá trình thực hiện bài tập***
 ### Xử lý lỗi:
 ### Lỗi Build

Khi bạn cố gắng xây dựng dự án, bạn có thể gặp lỗi sau:

```bash
FAILURE: Build failed with an exception.
* What went wrong:
Execution failed for task ':app:checkDebugAarMetadata'.
> A failure occurred while executing com.android.build.gradle.internal.tasks.CheckAarMetadataWorkAction
   > An issue was found when checking AAR metadata:
     
       1.  Dependency 'androidx.activity:activity:1.8.0' requires libraries and applications that
           depend on it to compile against version 34 or later of the
           Android APIs.
     
           :app is currently compiled against android-33.
     
           Recommended action: Update this project to use a newer compileSdk
           of at least 34, for example 34.
     
           Note that updating a library or application's compileSdk (which
           allows newer APIs to be used) can be done separately from updating
           targetSdk (which opts the app in to new runtime behavior) and
           minSdk (which determines which devices the app can be installed
           on).
* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
* Get more help at https://help.gradle.org
BUILD FAILED in 12s
```
![image](https://github.com/Mrk4tsu/Mobile-Dev/blob/FirebaseGeneral/Preview/error.png)
 Lỗi đang gặp xuất phát từ việc có một dependency trong dự án đang yêu cầu sử dụng phiên bản API (compileSdkVersion) của Android ít nhất là 34, nhưng dự án hiện tại đang được biên dịch với API level 33.
 
 ## Có 3 phương pháp để giải quyết nhanh chóng
 - #### Cách 1:
   Trên thanh công cụ chọn **File**->**Project** **Structure**\
   ![image](https://github.com/Mrk4tsu/Mobile-Dev/blob/FirebaseGeneral/Preview/cach1.png)
   Sau đó, chọn **Modules**, trong mục **Properties** thay đổi **Compile Sdk Version** thành 34<br>
   ![image](https://github.com/Mrk4tsu/Mobile-Dev/blob/FirebaseGeneral/Preview/cach01.png)
 - #### Cách 2:
   
   Ở danh sách các thư mục của dự án, chọn vào **build.gradle.kts(Module:app)**  <br>
   ![image](https://github.com/Mrk4tsu/Mobile-Dev/blob/FirebaseGeneral/Preview/cach2.png)

   Để ý ở đây **android** **compileSdk** đang là 33  <br>
   
   ![image](https://github.com/Mrk4tsu/Mobile-Dev/blob/FirebaseGeneral/Preview/cach3.png)
   
   Chỉ cần sửa lại thành 34 và chọn **Sync Now** để gradle đồng bộ<br>
   ![image](https://github.com/Mrk4tsu/Mobile-Dev/blob/FirebaseGeneral/Preview/syncnow.png)
 - #### Cách 3:
   Vẫn ở trong mục **build.gradle.kts(Module:app)**, dự án có 1 đoạn config **dependencies**, ở đây là các thư viện mà dự án mình đang sử dụng. Hãy để ý phần **material:material** của dự án. Ở đây chúng ta có thể chuyển version của **material:material** về cùng với version của **appcompat(1.6.1)**<br>
   ![image](https://github.com/Mrk4tsu/Mobile-Dev/blob/FirebaseGeneral/Preview/cach02.png)
    ![image](https://github.com/Mrk4tsu/Mobile-Dev/blob/FirebaseGeneral/Preview/cach002.png)
 
 ### Bài 2: ex.no.3 [Update 9/10 - Thêm xử lý sự kiện, UI design]
 ### [Chi tiết bài tập](https://github.com/Mrk4tsu/Mobile-Dev/tree/ExNo3#b%C3%A0i-1---about-me-giao-di%E1%BB%87n)
 ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160628776896569475/image.png?ex=65355ac7&is=6522e5c7&hm=c6255f5bfad91834125b78c73973d27eabeb8f4fa7fa6436310524135c47390c&)

 ### Bài 3: ex.no.1 [Update 10/10 - Thêm xử lý sự kiện, UI design]
 ### [Chi tiết bài tập](https://github.com/Mrk4tsu/Mobile-Dev/tree/exno1#b%C3%A0i-1-bmi-caculator-update-107---th%C3%AAm-x%E1%BB%AD-l%C3%BD-s%E1%BB%B1-ki%E1%BB%87n)
 ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1160995256079237170/image.png?ex=6536b017&is=65243b17&hm=6858cae24bc308696d9969cc70d2acac9043efcc4fd89c6e9823cfa1c9d30a6e&)

 ### 8* LinearLayout
 ### [Chi tiết bài tập](https://github.com/Mrk4tsu/Mobile-Dev/tree/ex.no.1#63cntt-mobile-dev-l%E1%BA%ADp-tr%C3%ACnh-%E1%BB%A9ng-d%E1%BB%A5ng-mobile)
 ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1155384740745068544/image.png)

  ### 9* LinearLayout
 ### [Chi tiết bài tập](https://github.com/Mrk4tsu/Mobile-Dev/tree/Bai9-LinearLayout#63cntt-mobile-dev-l%E1%BA%ADp-tr%C3%ACnh-%E1%BB%A9ng-d%E1%BB%A5ng-mobile)
 ![image](https://cdn.discordapp.com/attachments/1023849047045447700/1155480862167670866/image.png)


