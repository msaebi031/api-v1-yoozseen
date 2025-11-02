<?php
class YoozSeen
{
    private $key;
    private $baseUrl = "https://api.yoozseen.ir/api/v1/";

    public function __construct($apiKey)
    {
        $this->key = $apiKey;
    }

    private function post($data)
    {
        $ch = curl_init($this->baseUrl);
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);
        $response = curl_exec($ch);
        curl_close($ch);
        return json_decode($response, true);
    }

    // Get balance
    public function balance()
    {
        return $this->post(['key' => $this->key, 'action' => 'balance']);
    }

    // Get services
    public function services()
    {
        return $this->post(['key' => $this->key, 'action' => 'services']);
    }

    // Get order status
    public function status($orderId)
    {
        return $this->post(['key' => $this->key, 'action' => 'status', 'order_id' => $orderId]);
    }

    // Add order
    public function addOrder($params)
    {
        $data = array_merge(['key' => $this->key, 'action' => 'add'], $params);
        return $this->post($data);
    }
}

// ==========================
// Example Usage
// ==========================
$api = new YoozSeen("xxxxxxxxx");

// Balance
$balance = $api->balance();
print_r($balance);

// Services
$services = $api->services();
print_r($services);

// Status
$status = $api->status("1500035");
print_r($status);

// Add Boost Order
$boostOrder = $api->addOrder([
    'service' => 'id service',
    'link' => 'link boost',
    'quantity' => 100
]);
print_r($boostOrder);

// Add Likes/Votes Order
$likesOrder = $api->addOrder([
    'service' => 'id service',
    'link' => '@username',
    'quantity' => 50,
    'row' => 1,
    'column' => 1,
    'speed' => 0,
    'startdelay' => 0,
    'interval' => 0
]);
print_r($likesOrder);

// Add Reaction Order
$reactionOrder = $api->addOrder([
    'service' => 'id service',
    'link' => 'post link',
    'quantity' => 30,
    'reaction' => '👍',
    'speed' => 0,
    'startdelay' => 0,
    'interval' => 0
]);
print_r($reactionOrder);
