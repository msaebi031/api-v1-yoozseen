import axios from "axios";

export class YoozSeen {
  constructor(apiKey) {
    this.key = apiKey; // Your API Key
    this.baseUrl = `https://api.yoozseen.ir/api/v1/`;
  }

  // ==============================
  // Get Balance
  // ==============================
  async balance() {
    const data = { key: this.key, action: "balance" };
    const res = await axios.post(this.baseUrl, data);
    return res.data;
  }

  // ==============================
  // Get Services
  // ==============================
  async services() {
    const data = { key: this.key, action: "services" };
    const res = await axios.post(this.baseUrl, data);
    return res.data;
  }

  // ==============================
  // Check Order Status
  // ==============================
  async status(orderId) {
    const data = { key: this.key, action: "status", order_id: orderId };
    const res = await axios.post(this.baseUrl, data);
    return res.data;
  }

  // ==============================
  // Add Generic Order
  // Supports various types like: boost, followers, reactions, likes/votes
  // params is an object containing required fields per service
  // ==============================
  async addOrder(params) {
    const data = { key: this.key, action: "add", ...params };
    const res = await axios.post(this.baseUrl, data);
    return res.data;
  }
}

(async () => {
  const api = new YoozSeen("xxxxxxxxx"); // جایگذاری API Key

  // 1️⃣ گرفتن موجودی
  const balance = await api.balance();
  console.log("Balance:", balance);

  // 2️⃣ گرفتن سرویس‌ها
  const services = await api.services();
  console.log("Services:", services);

  // 3️⃣ وضعیت سفارش
  const status = await api.status("1500035");
  console.log("Order Status:", status);

  // 4️⃣ اضافه کردن یک سفارش Boost
  const boostOrder = await api.addOrder({
    service: "id service",
    link: "link boost",
    quantity: 100,
  });
  console.log("Boost Order:", boostOrder);

  // 5️⃣ اضافه کردن یک سفارش Likes/Votes
  const likesOrder = await api.addOrder({
    service: "id service",
    link: "@username",
    quantity: 50,
    row: 1,
    column: 1,
    speed: 0,
    startdelay: 0,
    interval: 0,
  });
  console.log("Likes Order:", likesOrder);

  // 6️⃣ اضافه کردن یک سفارش Reaction
  const reactionOrder = await api.addOrder({
    service: "id service",
    link: "post link",
    quantity: 30,
    reaction: "👍",
    speed: 0,
    startdelay: 0,
    interval: 0,
  });
  console.log("Reaction Order:", reactionOrder);
})();
