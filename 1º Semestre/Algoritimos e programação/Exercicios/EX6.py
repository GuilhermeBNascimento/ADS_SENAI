price = 200
discount = 20
FEE = 0.1

discount_value = price * (discount / 100)
price_after_discount = price - discount_value

fee = price_after_discount * FEE
final_price = price_after_discount + fee

print(final_price)