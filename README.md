# YoozSeen API Client

**YoozSeen** is a simple class to interact with the [YoozSeen API](https://api.yoozseen.ir).  
This class supports all main API functions:

- Check balance (`balance`)
- Get list of services (`services`)
- Check order status (`status`)
- Create various types of orders (`addOrder`) including:
  - View
  - Likes / Votes
  - Reactions
  - Stars
  - Boost links
  - Followers / Accounts
  - Member Telegram
    ,...

---

## 🚀 Installation

### Node.js / JavaScript

```bash
npm install axios
```

```js
import { YoozSeen } from "./YoozSeen";

const api = new YoozSeen("YOUR_API_KEY");

// Get balance
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

## 📦 Using `addOrder`

### Boost Links

```js
api.addOrder({
  service: "id service",
  link: "link boost",
  quantity: 100,
});
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
  interval: 0,
});
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
  interval: 0,
});
```

---

## 🌟 Features

- Supports all main YoozSeen API functions
- Simple and ready-to-use class for JS, PHP, Python, and Java
- No complex setup required, just use your `API Key`

---

## 📌 Notes

1. Make sure to get your `API Key` from the [YoozSeen Dashboard](https://api.yoozseen.ir).
2. Parameter values (like `link`, `quantity`) must match the selected service type.
3. If you have any questions, you can join this Telegram group and ask: [https://t.me/api_yoozseen](https://t.me/api_yoozseen)

---

## 🔗 Links

- YoozSeen Website: [https://yoozseen.ir](https://yoozseen.ir)
- API Documentation: [https://api.yoozseen.ir/docs](https://api.yoozseen.ir/docs)
