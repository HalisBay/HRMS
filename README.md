# Human Resources Management System (HRMS) - Backend

Bu proje, insan kaynakları yönetimini kolaylaştırmak için geliştirilmiş bir backend uygulamasıdır. Spring Boot kullanılarak inşa edilmiştir ve temel insan kaynakları süreçlerini yönetmek için gerekli olan API'leri sağlar.

## Özellikler

- **Kullanıcı Yönetimi:** Kullanıcıların sisteme kaydolması, oturum açması ve yetkilendirilmesi.
- **İş İlanları Yönetimi:** İş ilanlarının oluşturulması, güncellenmesi ve listelenmesi.
- **Başvuru Yönetimi:** Adayların iş ilanlarına başvurması ve başvuruların yönetimi.
- **Rol Tabanlı Erişim Kontrolü:** Farklı kullanıcı rolleri için farklı erişim seviyeleri.

## Teknolojiler

- **Java**
- **Spring Boot**
- **Spring Security**
- **Hibernate**
- **PostgreSQL**
- **Swagger** (API dokümantasyonu için)

## Kurulum ve Çalıştırma

1. **Depoyu Klonlayın:**

```bash
git clone https://github.com/HalisBay/HRMS.git
cd HRMS
```
2. **Bağımlılıkları Yükleyin:**
```bash
mvn install
```
4. **Veritabanı Yapılandırması:**
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```
6. **Programı Çalıştırın:**
```
mvn spring-boot:run
```
7. **API Dokümantasyonu:**
  Uygulama çalıştıktan sonra, Swagger arayüzüne http://localhost:8080/swagger-ui.html adresinden erişebilirsiniz.

