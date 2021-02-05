# Facade Design Pattern
> _**Facade Design Pattern , Structural Design Pattern grubunda yer alır.**_
>
> Facade Bir alt sistemin parçalarını oluşturan classları istemciden soyutlayarak kullanımı daha da kolaylaştırmak için tasarlanmış tasarım kalıbıdır. Mimarisel açıdan ise, karmaşık ve detaylı bir sistemi organize eden ve bir bütün olarak clientlara(istemcilere) sunan yapıdır.

&NewLine;

* Karmaşık ve detaylı olarak nitelendirdiğimiz bu sistemi bir alt sistem olarak varsayarsak eğer bu sistemi kullanacak clientlara daha basit bir arayüz sağlamak ve alt sistemleri bu arayüze organize bir şekilde dahil etmek ve bu alt sistemlerin sağlıklı çalışabilmesi için bu arayüz çatısı altında işin algoritmasına uygun işlev sergilemek istersek Facade Design Pattern’i kullanmaktayız.

&NewLine;
Daha somut bir örnek ile açıklayalım.

Öncelikle verdiğimiz stringi 3 farklı şifreleme algoritmasından birine şifreletmek istiyoruz.

İşe şifreleme yapacak sınıfları ve metodlarını yazarak başlayalım.

&NewLine;
AESEncryptor

    class AESEncryptor {
        public void encrypt(String text) {
            System.out.println("<AES>" + text + "</AES>");
        }
    }

&NewLine;
MD5Encryptor

    class MD5Encryptor {
        public void encrypt(String text, String key) {
            System.out.println("<MD5>" + text + key + "</MD5>");
        }
    }

&NewLine;
SHAEncryptor

    class SHAEncryptor {
        public void encrypt(String text, String key, boolean type) {
            if(type){
                System.out.println("<SHA>" + text + key + "</SHA>");
            }
            else{
                System.out.println("<SHA>" + key + text + "</SHA>");
            }
        }
    }

* Bütün classlarımıza farklı paketlerden erişilemesin diye access modifier olarak **public** kullanmadık._(Public kullanmamak zorunlu değildir.İstenilen duruma göre kullanılabilir)_

* Şimdi sırada bu classlarımız ile kullanıcı arasına farklı bir katman daha yazarak arka planda olan karmaşadan kullanıcımızı uzaklaştırmak olacak.

* Bu sayede arka planda yapılan işlere hakim olmayan kullanıcılar için de kodumuzu rahatlıkla kullanılabilir hale getirmiş olacağız.

&NewLine;
EncyptorFacade

    public class EncyptorFacade {
        private AESEncryptor aesEncryptor = new AESEncryptor();
        private MD5Encryptor md5Encryptor = new MD5Encryptor();
        private SHAEncryptor shaEncryptor = new SHAEncryptor();

        public void encrypt(String text, EncType encType){
            switch (encType){
                case AES: aesEncryptor.encrypt(text); break;
                case MD5: md5Encryptor.encrypt(text, "KEY"); break;
                case SHA: shaEncryptor.encrypt(text, "KEY", false); break;
                default: throw new IllegalArgumentException(encType.toString());
            }
        }

        public enum EncType{
            SHA,
            MD5,
            AES;
        }
    }

* Kullanıcımızın kullanımına sunacağımız metodlar bu sınıfta yazıldı.

* Farklı encrypt algoritmalarımızın instance'ları burada yaratıldı.

* Ayrıca kullanabileceğimiz algoritmalar enum olarak oluşturuldu.

* Tek yapmamız gereken **encrypt** metoduna şifrelemek istediğimiz stringi ve şifrelemek istediğimiz algoritma türünü vermek olacak.

* Arka planda kullandığım facade layer sayesinde bu algoritmaların istediği ek parametlerde default değerleri ile birlikte çalışmış olacak.

* Son olarak main içinde facade layer kullanmadan önceki ve sonraki hallerine bakalım.

&NewLine;
Facade Kullanmadan Önce:

    public class CustomEncryptor {
        public static void main(String[] args) {
            String text = "Content";
            AESEncryptor aesEncryptor = new AESEncryptor();
            aesEncryptor.encrypt(text);

            MD5Encryptor md5Encryptor = new MD5Encryptor();
            md5Encryptor.encrypt(text, "KEY");

            SHAEncryptor shaEncryptor = new SHAEncryptor();
            shaEncryptor.encrypt(text, "KEY", false);
        }
    }

* Görüldüğü üzere hem instace oluşturma, hemde parametreleri doldurma işi kullanıcaya verilmiş oldu.


&NewLine;
Facade Layer İle:

    public class CustomEncryptor {
        public static void main(String[] args) {
            String text = "Content";
            EncyptorFacade encyptorFacade = new EncyptorFacade();
            encyptorFacade.encrypt(text, EncyptorFacade.EncType.AES);
        }
    }
* Kullanıcımızın sadece stringi ve kullanacağı algoritmayı vermesi yeterli.
* Böylelikle kullanıcının kodunu kullanma kolaylığını arttırmış olduk.

## Kaynaklar

- https://www.youtube.com/watch?v=_q8e7ysOc-c&list=PLd0jsEi3hUAe6qL7iDfDzr8n8DvigHXmv&index=5&ab_channel=HaydiKodlayalim

- https://medium.com/@veysel.gunes36/facade-desi%CC%87gn-pattern-%C3%B6n-y%C3%BCz-tasar%C4%B1m-desen-1bd79ba38db3