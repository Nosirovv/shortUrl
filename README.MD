# shortUrl

shortUrl — bu URL qisqartiruvchi dastur bo'lib, foydalanuvchilarga uzun URLlarni qisqa formatda taqdim etadi.

# Talablar

Loyihani o'rnatish va ishlatishdan oldin quyidagi dasturiy ta'minotlarning o'rnatilganligini tekshiring:

1. Java 17 yoki undan yuqori: Dastur Java 17 yoki yuqoriroq versiyada ishlaydi.
2. Maven: Loyihaning bog'liqliklarini boshqarish uchun ishlatiladi.
3. PostgreSQL: Ma'lumotlar bazasi sifatida ishlatiladi.
4. Git: Repozitoriyani klonlash uchun kerak.

O'rnatish bo'yicha qadamlar
Dasturdan foydalanish uchun quyidagi qadamlarni bajaring:

1. Git orqali loyihani klonlash
   Lokal kompyuteringizga repozitoriyani klonlash uchun quyidagi komandani ishlating:
   ```shell
   git clone https://github.com/user/myproject.git
   cd myproject
   ```
2. Ma'lumotlar bazasini sozlash
   PostgreSQL ma'lumotlar bazasi yaratish va foydalanuvchi ma'lumotlarini sozlash uchun quyidagi qadamlarni bajaring:
    1. Malumotlar bazasini yaratish: >> CREATE DATABASE shortUrl;
    2. Loyihadagi application.properties faylini tahrirlash: >>
       ```
       spring.datasource.url=jdbc:postgresql://localhost:5432/url_shortener
       spring.datasource.username=your_username
       spring.datasource.password=your_password
       ```
3. Maven orqali loyihani yig'ish va bog'liqliklarni o'rnatish
   Loyiha bog'liqliklarini o'rnatish va loyihani yig'ish uchun quyidagi komandani bajaring:>>
   ```
   mvn clean install
   ```
4. Dastur konfiguratsiyasini sozlash
   Agar qo'shimcha konfiguratsiyalar kerak bo'lsa, application.properties faylini sozlashingiz mumkin. Masalan, portni
   o'zgartirish yoki boshqa sozlamalarni tahrirlash.
5. Dasturni ishga tushirish
   Dastur Spring Boot ilovasi bo'lgani uchun uni quyidagi komanda bilan ishga tushirishingiz mumkin: >>
   ```shell
   mvn spring-boot:run
   ```

**Ishga tushirgandan so'ng, ilova http://localhost:8080 manzilida ishlaydi.**

# API Qo'llanmasi

1. URL qisqartirish
   > Endpoint: /shorten
   >
   > Method: POST
   >
   > shunday qilib url berib yuboring
   >
   > localhost:8080/shorten?url=https://www.example.com

   Response: Qisqa url qaytariladi
   > "http://localhost:8080/abc123"

2. Qisqartirilgan urlni asl urlga yo'naltirish
   > Endpoint: /{shortUrl}
   >
   > Method: GET
   >
   > Request: http://localhost:8080/abc123.
   
   Response: asl saytga yo'naltiradi 
 