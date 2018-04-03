/*package com.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DAO.ProductDAO;
import com.model.Product;

public class ProductUnitTest {
	static ProductDAO productDAO;
@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.*");
	context.refresh();
	
	productDAO=(ProductDAO)context.getBean("productDAO");
}

@Test
public void addCategoryTest()
{
	Product product=new Product();
	product.setProductId(1);	
	product.setProductName("Regularfit");
	product.setProdDesc("Fittings");

	product.setSupplierId(1);
	product.setPrice(599);
	product.setStock(1);
	
	assertTrue("Problem in Product Insertion",productDAO.addProduct(product));
}

@Ignore
@Test
public void getProductTest()
{
	assertNotNull("Problem in get Product",productDAO.getProduct(1));
}

@Ignore
@Test
public void deleteProductTest()
{
	Product product=productDAO.getProduct(1);
	assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
}

@Test
public void updateCategoryTest()
{
	Product product=productDAO.getProduct(1);
	product.setProductName("L Sofa Model");
	assertTrue("Problem in Updation",productDAO.updateProduct(product));
}
@Test
public void listProductTest()
{
	List<Product> listProducts=productDAO.listProducts();
    assertNotNull("No Products",listProducts);

	
	for(Product product:listProducts)
	{
		System.out.print(product.getProductId()+":::");
		System.out.print(product.getProductName()+":::");
		System.out.println(product.getProdDesc());
		
		System.out.println(product.getSupplierId());
		System.out.println(product.getPrice());
		System.out.println(product.getStock());
				}
}
	

}
*/