# CRC Cards Improved Order Processing System

## Class: Order
**Responsibilities:**
- Store order details (customer name, email, item, price)
- Provide access to order data through getters/setters
- Maintain order state

**Collaborators:**
- PricingService
- ReceiptPrinter
- OrderRepository
- NotificationService

## Class: PricingService
**Responsibilities:**
- Calculate tax and total price
- Apply discounts based on pricing rules
- Encapsulate business logic related to pricing

**Collaborators:**
- Order
- DiscountStrategy

## Class: DiscountStrategy
**Responsibilities:**
- Define discount rules
- Apply appropriate discount based on conditions (e.g., price threshold)

**Collaborators:**
- PricingService

## Class: ReceiptPrinter
**Responsibilities:**
- Generate and print order receipts
- Format output for display

**Collaborators:**
- Order
- PricingService

## Class: OrderRepository
**Responsibilities:**
- Persist order data to storage (file, database, etc.)
- Handle reading/writing of order records

**Collaborators:**
- Order

## Class: NotificationService
**Responsibilities:**
- Send confirmation messages to customers
- Handle communication logic (e.g., email notifications)

**Collaborators:**
- Order

## Class: LoggerService
**Responsibilities:**
- Log system activity (e.g., order processing time)
- Provide a centralized logging mechanism

**Collaborators:**
- OrderProcessor

---

## Class: OrderProcessor
**Responsibilities:**
- Coordinate the overall order processing workflow
- Delegate tasks to appropriate services
- Ensure proper sequence of operations

**Collaborators:**
- Order
- PricingService
- ReceiptPrinter
- OrderRepository
- NotificationService
- LoggerService