-- 코드를 입력하세요
SELECT ROUND(AVG(car.DAILY_FEE)) as AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR car
WHERE car.CAR_TYPE = 'SUV'
