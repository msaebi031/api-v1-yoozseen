# YoozSeen API Client

**YoozSeen** یک کلاس ساده برای تعامل با [YoozSeen API](https://api.yoozseen.ir) است.  
این کلاس از تمام توابع مهم API پشتیبانی می‌کند:  

- مشاهده موجودی (`balance`)  
- دریافت لیست سرویس‌ها (`services`)  
- بررسی وضعیت سفارش (`status`)  
- ایجاد سفارش‌های مختلف (`addOrder`) شامل:
  - Boost لینک‌ها
  - فالوور / اکانت‌ها
  - لایک‌ها / Votes
  - Reactions

---

## 🚀 نصب و راه‌اندازی

### Node.js / JavaScript

```bash
npm install axios
```

```js
import { YoozSeen } from "./YoozSeen";

const api = new YoozSeen("YOUR_API_KEY");

// دریافت موجودی
const balance = await api.balance();
console.log(balance);
```

### Python

```bash
pip install requests
```

```python
from yoozseen import YoozSeen

api = YoozSeen("YOUR_API_KEY")
print(api.balance())
```

### PHP

```php
require 'YoozSeen.php';
$api = new YoozSeen("YOUR_API_KEY");
print_r($api->balance());
```

### Java

```bash
javac YoozSeen.java
java YoozSeen
```

---

## 📦 استفاده از `addOrder`

### Boost لینک‌ها

```js
api.addOrder({
    service: "id service",
    link: "link boost",
    quantity: 100
})
```

### Likes/Votes

```js
api.addOrder({
    service: "id service",
    link: "@username",
    quantity: 50,
    row: 1,
    column: 1,
    speed: 0,
    startdelay: 0,
    interval: 0
})
```

### Reactions

```js
api.addOrder({
    service: "id service",
    link: "post link",
    quantity: 30,
    reaction: "👍",
    speed: 0,
    startdelay: 0,
    interval: 0
})
```

---

## 🌟 ویژگی‌ها

- پشتیبانی از تمام توابع مهم YoozSeen API  
- یک کلاس ساده و آماده استفاده برای JS, PHP, Python, Java  
- بدون نیاز به تنظیمات پیچیده، فقط کافی است `API Key` خود را جایگذاری کنید  

---

## 📌 نکات

1. حتماً `API Key` خود را از [داشبورد YoozSeen](https://api.yoozseen.ir) دریافت کنید.  
2. برای اجرای Java، نام فایل باید `YoozSeen.java` باشد.  
3. مقادیر پارامترها (مثل `link`, `quantity`) باید مطابق نوع سرویس انتخاب شوند.  

---

## 🔗 لینک‌ها

- وبسایت YoozSeen: [https://yoozseen.ir](https://yoozseen.ir)  
- مستندات API: [https://api.yoozseen.ir/docs](https://api.yoozseen.ir/docs)
