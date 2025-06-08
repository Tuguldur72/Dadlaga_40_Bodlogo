# The Time in Words

**Бодлогын холбоос:**  
https://www.hackerrank.com/challenges/the-time-in-words/problem

## Бодлогын орчуулга

Танд `h` болон `m` гэсэн хоёр бүхэл тоо өгөгдөнө. Та эдгээрийг цагийн хэлбэрээр **үгээр** илэрхийлж бичнэ үү.

**Тайлбар:**

- `h` нь 1 ≤ h ≤ 12 (цагийг илэрхийлнэ)
- `m` нь 0 ≤ m < 60 (минутыг илэрхийлнэ)

Жишээлбэл:

- `5:00` → `"five o' clock"`
- `5:01` → `"one minute past five"`
- `5:10` → `"ten minutes past five"`
- `5:15` → `"quarter past five"`
- `5:30` → `"half past five"`
- `5:40` → `"twenty minutes to six"`
- `5:45` → `"quarter to six"`
- `5:47` → `"thirteen minutes to six"`
- `5:59` → `"one minute to six"`

## Шийдлийн тайлбар

1. 0 минут байвал:  
   - `"five o' clock"` гэх мэт.

2. 1 ≤ m ≤ 30 бол:  
   - `"x minute(s) past h"`  
   - `15` → `"quarter past h"`  
   - `30` → `"half past h"`

3. 31 ≤ m < 60 бол:  
   - `"x minute(s) to h+1"`  
   - `60 - m` минутыг тооцоолно.  
   - `15` → `"quarter to h+1"`

4. Тусгай нэршилтэй тоонууд (`one`, `two`, ..., `twenty nine`, `half`, `quarter`) болон `minute` эсвэл `minutes` гэсэн ялгааг анхаарна.

## Жишээ

**Оролт:**
h = 5
m = 45

**Гаралт:**
quarter to six

## Бодлогын шалгасан нөхцлүүд

- Тоонуудыг англи үгээр зөв хөрвүүлж буй эсэх.
- `past` болон `to` гэсэн хоёр бүтцийн зөв хэрэглээ.
- `quarter`, `half`, `minute/minutes` ялгалтыг зөв ашигласан эсэх.
- `h = 12` тохиолдолд `h+1 = 1` гэдгийг тооцсон эсэх.