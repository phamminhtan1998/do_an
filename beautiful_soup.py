import requests
import mysql.connector
from bs4 import BeautifulSoup



#soup=BeautifulSoup(open("fahasa.html", encoding="UTF-8"),features="lxml")
#divs =soup.find_all('div',{"class":"product images-container"})

#connect the database in mysql do_an_tot_nghiep
mydb = mysql.connector.connect(user="root",password="dhan12345",database="do_an_tot_nghiep")
my_cursor = mydb.cursor()

    

for index in range(1, 2, 1) :
    r=requests.get(f'https://tiki.vn/nha-sach-tiki/c8322?src=c.8322.hamburger_menu_fly_out_banner&page={index}',headers={"User-Agent": "Mozilla/5.0"})
    soup=BeautifulSoup(r.content,"lxml")
    divs =soup.find_all('div',{"class":"product-item"})
    for div in divs:
        author=div.find('p',{'class':'author'})
        name_author =""
        if author is not None :
            name_author=author.text
        else:
            name_author=" no author "
        
        image =div.find_all('img',{'class':'product-image img-responsive'})[0]
        price =div.find('span',{'class':'final-price'})  
        
        sql = 'insert into test (title,img_url,price,author) values (%s,%s,%s,%s)'
        val = (div['data-title'],image['src'],str(price.next_element),name_author)
        my_cursor.execute(sql,val)
        mydb.commit()



 