SELECT product_code, SUM(price*sales_amount) AS SALES
FROM PRODUCT P
JOIN OFFLINE_SALE OS
ON P.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY product_code
ORDER BY SUM(price*sales_amount) DESC, product_code;
