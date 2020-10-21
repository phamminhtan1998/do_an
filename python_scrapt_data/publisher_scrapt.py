from bs4 import BeautifulSoup
import mysql.connector
import requests

mydb = mysql.connector.connect(user="root",password="dhan12345",database="do_an_tot_nghiep")
my_cursor = mydb.cursor()
r=requests.get("https://tiki.vn/nha-sach-tiki/c8322",headers={"User-Agent":"Mozilla/5.0"})
div_list_publisher = BeautifulSoup(r.content,"lxml")
list_publisher=div_list_publisher.find('div',{"aria-labelledby":"heading-publisher_vn"})
values = list_publisher.find_all('a',{"class":"list-group-item"})
name_publisher = ""
i=1
for v in values :
    name_publisher = str(v.next_element).strip()
    sql ="INSERT INTO publisher (id,name) VALUES (%s,%s)"
    val=(i,name_publisher)
    # my_cursor.execute(sql,val)
   # mydb.commit()
    i=i+1


