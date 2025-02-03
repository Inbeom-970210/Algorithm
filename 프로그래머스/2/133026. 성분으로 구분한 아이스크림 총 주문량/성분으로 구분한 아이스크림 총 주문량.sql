-- 코드를 입력하세요
SELECT I.INGREDIENT_TYPE, SUM(FH.TOTAL_ORDER) AS TOTAL_ORDER
FROM ICECREAM_INFO I
LEFT JOIN FIRST_HALF FH ON I.FLAVOR = FH.FLAVOR
GROUP BY I.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER