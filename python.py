import requests

class YoozSeen:
    def __init__(self, api_key):
        self.key = api_key
        self.base_url = "https://api.yoozseen.ir/api/v1/"

    def _post(self, data):
        response = requests.post(self.base_url, json=data)
        return response.json()

    # Get balance
    def balance(self):
        return self._post({"key": self.key, "action": "balance"})

    # Get services
    def services(self):
        return self._post({"key": self.key, "action": "services"})

    # Get order status
    def status(self, order_id):
        return self._post({"key": self.key, "action": "status", "order_id": order_id})

    # Add order
    def add_order(self, params):
        data = {"key": self.key, "action": "add", **params}
        return self._post(data)

# ==========================
# Example Usage
# ==========================
api = YoozSeen("xxxxxxxxx")

# Balance
print(api.balance())

# Services
print(api.services())

# Status
print(api.status("1500035"))

# Add Boost Order
print(api.add_order({
    "service": "id service",
    "link": "link boost",
    "quantity": 100
}))

# Add Likes/Votes Order
print(api.add_order({
    "service": "id service",
    "link": "@username",
    "quantity": 50,
    "row": 1,
    "column": 1,
    "speed": 0,
    "startdelay": 0,
    "interval": 0
}))

# Add Reaction Order
print(api.add_order({
    "service": "id service",
    "link": "post link",
    "quantity": 30,
    "reaction": "👍",
    "speed": 0,
    "startdelay": 0,
    "interval": 0
}))
