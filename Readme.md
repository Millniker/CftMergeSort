# Сортировка слиянием нескольких файлов

### Входные данные
На вход подается один или более файлов. В каждом из файлов данные передаются в столбик, предварительно остартированы.

### Выходные данные
На выходе получаем новый файл с отсортированными данными из других файлов.

### Инструкция по запуску
В директории с проектом прописать:

mvn compile
mvn package
cd target
java -jar MergeSortCFT-1.0-jar-with-dependencies.jar [-a|-d] {-i|-s} outfile.txt infile1.txt [infile2.txt...]

### Описание параметров:
-a - соритровка по возрастанию (необязательный, по умолчанию)<br>
-d - сортировка по убыванию (необязательный)<br>
-i - сортировка целых чисел (обязательный)<br>
-s - сортировка строк (обязательный)<br>
outfile.txt - название выходного файла<br>
infile1.txt - название входного файла (не менее одного)<br>

Версия Java
Java 19

Система сборки
Apache Maven 4.0.0

Сторонние библиотеки
Apache Commons CLI 1.5.0 