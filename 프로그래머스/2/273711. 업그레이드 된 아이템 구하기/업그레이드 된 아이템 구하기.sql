-- 코드를 작성해주세요
SELECT info.ITEM_ID, info.ITEM_NAME, info.RARITY
FROM (SELECT *
        FROM ITEM_INFO i
        WHERE i.RARITY = "RARE"
      ) sub
JOIN ITEM_TREE tree
ON sub.ITEM_ID = tree.PARENT_ITEM_ID
JOIN ITEM_INFO info
ON tree.ITEM_ID = info.ITEM_ID
ORDER BY info.ITEM_ID DESC;