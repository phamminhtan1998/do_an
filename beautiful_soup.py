import requests
import mysql.connector
from bs4 import BeautifulSoup
from random import randint,randrange
from datetime import datetime


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
        link_book_detail = div.find('a',href=True)
        link = link_book_detail['href']

        str_description=""
        name_author =""
        cover_type =""
        publisher =""
        date_publish=""
        r_detail = requests.get(f'https://tiki.vn{link}',headers={"User-Agent":"Mozilla/5.0"})
        soup_detail= BeautifulSoup(r_detail.content,"lxml")
        div_detail = soup_detail.find('div',{"class":"ProductDescription__Wrapper-fuzaih-0 khHtLW"})
        try:
            div_description= div_detail.find('div',{"class","ToggleContent__Wrapper-sc-1hm81e2-1 iGyNLs"})
            book_detail_table = div_detail.find('div',{"class":"content has-table"})
            div_content_description = div_description.find_all('p')
            
            for value in div_content_description :
                str_description+=str(value.text)
              
            
            try:
                td_cover_type= book_detail_table.find(string="Loại bìa")
                td_number_page= book_detail_table.find(string="Số trang")
                td_publisher=book_detail_table.find(string="Nhà xuất bản")
                td_date_publish=book_detail_table.find(string="Ngày xuất bản")
                date_publish= str(td_date_publish.find_next('td').contents[0])
                publisher=str(td_publisher.find_next('td').contents[0])
                cover_type = str(td_cover_type.find_next('td').contents[0])
                number_page= int(td_number_page.find_next('td').contents[0],base=16)
                if cover_type is string.empty :
                    cover_type="404 not found"                

            except expression as identifier:
                cover_type = "404 not found"
                publisher=" 404 not found"
                date_publish=" 404 not found"
   
        except :
            print("sorry")
      
        if author is not None :
            name_author=str(author.text)
        else:
            name_author=" no author "

        image =div.find_all('img',{'class':'product-image img-responsive'})[0]
        main_price = float(div['data-price'])
        title= div["data-title"]
        img_src = image['src']
        sale= randrange(0, 30)
        weight=randrange(10,50)
      
        val = (name_author, cover_type,img_src,str_description,'viet nam',title,number_page,main_price,sale,weight,date_publish,publisher)
        
        sql = "INSERT INTO do_an_tot_nghiep.book ( author, cover, image_url,description, language, name, number_page, price, sale, weight, year_publish, publisher) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
        my_cursor.execute(sql,val)
        mydb.commit()

      

      





 