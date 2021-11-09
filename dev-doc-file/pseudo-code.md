This document is insignificant. I wrote before start coding, doesn't represent the final state.

## Bildirim Kuralları

### Genel Bildirimler
* Tüm kullanıcılara bildirim (üründen bağımsız genel bildirim)
* Belirli ürüne sahip kullanıcılara bildirim (ilgili ürünlere hitap eden genel bildirim)
* Belirli ürüne sahip kullanıcılara bildirim (ilgili ürünlere hitap eden yeni bir kampanya eklendiği için genel bildirim)

### Daha Spesifik Bildirimler
* Kullanıcının ödemesinin yaklaşması.  
* Kullanıcının ödemesinin gecikmesi.
* Kullanıcının ürününün son kullanma tarihinin yaklaşması.

vs... (Spesifik bildirimler ilk etapta implement edilmeyecek)
  
### Bildirimlerin İletilmesi
Bildirimler mail + push notification olarak 2 şekilde de kullanıcıya iletilmeli.

---

# Pseudo Code



### Campaign Service

#### Fields
* id : Long
* name : String
* description : String
* isGeneral : Boolean
* products : List<Product>

#### Rules
* Campaign içindeki isGeneral fieldı true ise -> tüm kullanıcalara bildirim iletilecektir. (isGeneral propertysi tutulmalı (performans))
* Campaign içindeki product list incelenilir ve bu ürünlere sahip olan kullanıcalara bildirim iletilir. (product list propertysi tutulmalı)
* Campaign eklenince notification servisi otomatik olarak tetiklenir.

#### Methods:
* create() 
  * notificationService : sendNotificaiton()
* read()
* update()
* delete()

---

### Notification Service

#### Fields
id

#### Rules
* Mail Service + Push Notification Service'den oluşan compose bir servistir. Bu iki servise bağımlı.
* Notification servisi user servisinden userları çeker ve campaign usera hitap ederse bildirimleri gönderir

#### Methods:
* sendNotification() :
  * mailService : sendMail()
  * pushNotificationService : sendPushNotification()
* campaignAndUserProductsCompare()
  * campaignService : getCampaigns()
  * userService : getUsers()

---
  
### Product Service

#### Fields
* id : Long
* name : String
* description : String
* productCategory : ProductCategory

#### Rules

#### Methods:
* create()
* read()
* update()
* delete()

---

### User Service

#### Fields
* id : Long
* name : String
* surname : String
* email : String
* products : List<Product>

#### Rules

#### Methods:
* create()
* read()
* update()
* delete()