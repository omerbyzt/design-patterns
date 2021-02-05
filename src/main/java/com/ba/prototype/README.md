# Prototype Design Pattern

> _**Prototype Design Pattern, Creational Design Pattern grubunda yer alır.**_
>
> Yaptığımız projemizde nesnemizi birden fazla oluşturmamız gerektiğinde normalde “new” olarak oluşturmak yerine bir tane oluşturduğumuz nesnemizin klonunu oluşturmamızı sağlayan bir design patterndir.

&NewLine;
* Prototype Pattern kullanılmasının amacı üretilen nesnenin çok kaynak tüketmesi durumunun engellenmesini sağlamaktır.

&NewLine;
* Daha somut bir örnek ile açıklayalım.

1. Uye classımızı oluşturalım

    Uye
    ```
    public class Uye implements Cloneable {

            private List<String> uyeListesi;

            public Uye() {
                uyeListesi = new ArrayList<String>();
            }

            public Uye(List<String> liste) {
                this.uyeListesi = liste;
            }

            public void uyeEkle() {

                uyeListesi.add("Burak");
                uyeListesi.add("Ahmet");
                uyeListesi.add("Mehmet");
            }

            public List<String> getUyeListesi() {
                return uyeListesi;
            }

            @Override
            public Object clone() throws CloneNotSupportedException {
                List<String> uyeListesi = new ArrayList<String>();
                for (String s : this.getUyeListesi()) {
                    uyeListesi.add(s);
                }
                return new Uye(uyeListesi);
            }
        }
    ```
* Bu sınıf içinde öncelikle **Cloneable** interface'ini implement ediyoruz.

* Ardından üyelerimizi tutacak olan listemizi **private** tanımlıyoruz ve constructor'larını oluşturuyoruz.

* Listemizi daha kolay doldurmak için **uyeEkle()** metodunu yazıp içinde üyelerimizi ekliyoruz.

* Üye listesini alabilmek için **getUyeListesi()** metodunu yazıyoruz.

* En önemli nokta olarak ise **Object clone()** metodunu override ediyoruz.

* Bu metod içinde yeni bir liste açıp, listemizdeki tüm elemanları yeni açtığımız listeye doldurup, bu listeyi de yeni bir **Uye instance'ına** parametre olarak veriyoruz.

* Böylelikle bir klonlama işlemi yaparak yeni nesne üzerine ekleme, çıkarma ya da silme işlemlerini sorunsuz olarak az kaynak tüketerek yapabiliyoruz.

### Kaynaklar

- https://blog.burakkutbay.com/design-patterns-prototype-pattern-nedir.html/
