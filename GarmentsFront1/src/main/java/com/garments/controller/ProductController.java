package com.garments.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.DAO.CategoryDAO;
import com.DAO.ProductDAO;
import com.model.Category;
import com.model.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

		@RequestMapping(value="/admin/product")
	public ModelAndView getAllProducts(Model model){
			List<Product> listProducts = productDAO.listProducts();
			List<Category> listCategories=categoryDAO.getCategory();
			System.out.println(listCategories);
			model.addAttribute("listCategories", listCategories);
			model.addAttribute("listProducts", listProducts);
			return new ModelAndView("Product");			
		} 
		@RequestMapping("all/viewallproducts")
		public ModelAndView selectByCategory(@RequestParam String searchCondition,Model model){

		List<Product> listproduct = productDAO.getProductsbasedonCatId(Integer.parseInt(searchCondition));
		model.addAttribute("listproduct", listproduct);
		return new ModelAndView("ViewProducts");
	}
		@RequestMapping("/admin/addpro")
	public String addProducts(@RequestParam("proname") String proname, @RequestParam("prodesc") String prodesc,  @RequestParam("procost") int procost,@RequestParam("img")MultipartFile filedet,@RequestParam("stock") int stock,ModelMap model,@RequestParam("categoryId") int categoryId) {
		Product product=new Product();
		product.setProductName(proname);
		product.setProdDesc(prodesc);
		product.setPrice(procost);
		product.setImg(filedet);
		product.setPrice(stock);
		product.setCategory(categoryDAO.getCategory(categoryId));
		
		productDAO.addProduct(product);	
		String imagePath="F:\\eclipse\\workspace\\GarmentsFront1\\src\\main\\webapp\\resources\\images";
		imagePath=imagePath+String.valueOf(product.getProductId())+".jpg";
		File image=new File(imagePath);
		
		if(!filedet.isEmpty())
		{			
			try 
			{
				byte[] fileBuffer=filedet.getBytes();	
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();
			}
			catch (Exception e)
			{
				System.out.println("Exception Arised:"+e);
				e.printStackTrace();
			}		
		}
		else
		{
			System.out.println("Problem Occured in File Uploading");
		}
		
				
		List<Product> listProducts = productDAO.listProducts();
		List<Category> listCategories=categoryDAO.getCategory();
		System.out.println(listCategories);
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("listProducts", listProducts);
		return "Product";			
	}

	@RequestMapping("/admin/add")
	public String showProduct(Model m) {
		List<Product> listProducts = productDAO.listProducts();		
		List<Category> listCategories=categoryDAO.getCategory();
		m.addAttribute("listCategories", listCategories);
		m.addAttribute("listProducts", listProducts);
		return "Product";
	}
	@RequestMapping(value="/admin/UpdateProduct",method=RequestMethod.POST)
	public String updateProductInDB(@RequestParam("proid") int productId,@RequestParam("proname") String proname,@RequestParam("prodesc") String prodesc,@RequestParam("procost") int procost,@RequestParam("stock") int stock,Model m)
	{
		Product product=productDAO.getProduct(productId);
		product.setProductName(proname);
		product.setProdDesc(prodesc);
		product.setPrice(procost);
		product.setStock(stock);
		
		productDAO.updateProduct(product);
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts",listProducts);
		return "Product";
	}
	
	@RequestMapping("/admin/updateProduct/{productId}")
	public String updateProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);		
		List<Product> listProducts=productDAO.listProducts();
		System.out.println("in product controller-------------");
		System.out.println(product.getProductName());
		System.out.println(listProducts.get(0).getProdDesc());
		m.addAttribute("listProducts",listProducts);
		m.addAttribute("productInfo",product);
		return "UpdateProduct";
	}
	
	@RequestMapping("/admin/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId,Model m)
	{	Product product=productDAO.getProduct(productId);		
		productDAO.deleteProduct(product);		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts",listProducts);
		return "Product";
	}
}