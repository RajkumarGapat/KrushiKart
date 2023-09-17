import "./App.css";
import { Container, Row, Col } from "react-bootstrap";
import Footer from "./components/footer";
import Header from "./components/Header";
import Menus from "./components/Menus";
import { Card, CardGroup } from "react-bootstrap";
import Carousel from "./components/carousel";
import HomeScreen from "./screens/HomeScreen";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ProductDetails from "./screens/ProductDetails";
import SeedScreen from "./screens/SeedScreen";
import FertilizerScreen from "./screens/FertilizerScreen";
import LoginScreen from "./screens/LoginScreen";
import Layout from "./components/Layout";
import Pagenotfound from "./screens/Pagenotfound ";
import RegisterScreen from "./screens/Auth/RegisterScreen";
import toast, { Toaster } from 'react-hot-toast';
import Login from "./screens/LoginScreen";
import ForgotPassword from "./screens/password/ForgotPassword";
import VerifyOtp from "./screens/password/VerifyOtp";
import NewPassword from "./screens/password/NewPassword";
import AdmindashboardScreen from "./screens/AdmindashboardScreen"
import SellerdashboardScreen from "./screens/SellerdashboardScreen"
import CreateCategory from "./screens/Admin/CreateCategory";
import AddProduct from "./screens/Seller/AddProduct";
import AllUsers from "./screens/Admin/AllUsers";
import SellerOrders from "./screens/Seller/SellerOrders";
import ContactScreen from "./screens/ContactScreen";
import AllProducts from "./screens/Admin/AllProducts";
import CardScreen from "./screens/CardScreen"
import MachineriesScreen from "./screens/Seller/MachineriesScreen";
import PaymentSceen from "./screens/PaymentSceen";



function App() {
  return (

    <Router>
      <Header />
      <main className="my-3 ms-3 me-3 min-vh-100">
        <Carousel />
        <hr></hr>

        {/* <Col md={3}>
            <Menus />
          </Col> */}

        <Routes>
          <Route path="/" element={<HomeScreen />} exact />
          <Route path="/api/prod/prod/:id" element={<ProductDetails />} />
          <Route path="/cart" element={<CardScreen />} />
          <Route path="/api/prod/Seeds" element={<SeedScreen />} />
          <Route path="/api/prod/fertilizers" element={<FertilizerScreen />} />
          <Route path="/api/prod/Machineries" element={<MachineriesScreen />} />
          <Route path="/api/auth/signin" element={<LoginScreen />} />
          <Route path="*" element={<Pagenotfound />} />
          <Route path="/api/auth/user/signup" element={<RegisterScreen />} />
          <Route path="/api/user/forgotpassword" element={<ForgotPassword />} />
          <Route path="/api/user/verify" element={<VerifyOtp />} />
          <Route path="/api/user/newpassword" element={<NewPassword />} />

          <Route path="/admindashboard" element={<AdmindashboardScreen />} />
          <Route path="/sellerdashboard" element={<SellerdashboardScreen />} />
          <Route path="/createcategory" element={<CreateCategory />} />
          <Route path="/allproducts" element={<AllProducts />} />


          <Route path="/addproduct" element={<AddProduct />} />
          <Route path="/allusers" element={<AllUsers />} />
          <Route path="/sellerorders" element={<SellerOrders />} />

          <Route path="/contactpage" element={<ContactScreen />} />
          <Route path="/paymentpage" element={<PaymentSceen />} />

        </Routes>

        <Toaster />


      </main>
      <Footer />
    </Router>

  );
}

export default App;
