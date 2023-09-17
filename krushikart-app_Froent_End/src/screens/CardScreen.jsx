import React, { useState, useEffect } from 'react'
import { useAuth } from '../context/auth'
import { useCart } from '../context/Cart'
import { useNavigate } from 'react-router-dom'
import DropIn from 'braintree-web-drop-in-react'
import toast from 'react-hot-toast'
import '../styles/CartStyles.css'
import base_url from '../api/bootapi'
import httpClient from '../http-common'
import { Button } from 'react-bootstrap'

const CardScreen = () => {
  const [auth, setAuth] = useAuth()
  const [cart, setCart] = useCart()
  const navigate = useNavigate()

  const totalPrice = () => {
    try {
      let total = 0
      cart?.map((item) => {
        total = total + item.unitPrice
      })
      // return total
      // return total.toLocaleString('en-US', {
      //   style: 'currency',
      //   currency: 'USD',
      // })
      return '₹' + total
    } catch (error) {
      console.log(error)
    }
  }

  const removeCartItem = (pid, pname) => {
    try {
      let myCart = [...cart]
      let index = myCart.findIndex((item) => item.id === pid)
      // toast.success(`${pname} is removed from cart successfully.`)
      myCart.splice(index, 1)
      setCart(myCart)
      localStorage.setItem('cart', JSON.stringify(myCart))
    } catch (error) {
      console.log(error)
    }
  }

  return (
    //  <h1>Add to cart page</h1>
    <div className="container">
      <div className="row">
        <div className="col-md-12">
          <h1 className="text-center bg-light p-2 mb-1">
            {/* `Hello ${auth?token && auth?.user?.firstName}` */}
            {/* {`Hello ${auth.user.firstName}`}
          </h1>
          <h4 className="text-center">
            {cart.length > 1`You Have ${cart.length} items in your cart`}
          </h4> */}
            {!auth.user ? 'Hello Guest' : `Hello  ${auth.user.firstName}`}
            <h4 className="text-center">
              {cart.length
                ? `You Have ${cart.length} items in your cart ${
                    auth.user ? '' : 'please login to checkout !'
                  }`
                : ' Your Cart Is Empty'}
            </h4>
          </h1>
        </div>
        <div className="row">
          <div className="col-md-8">
            {cart.map((p) => (
              <div className="row mb-2 p-2 card flex-row">
                <div className="col-md-4">
                  <div
                    className="card m-2"
                    style={{ width: '150px', height: '150px' }}
                  >
                    <img
                      to={`/api/prod/prod/${p.id}`}
                      className="card-img-top"
                      alt={p.prodName}
                      src={p.imageUrl}
                    />
                  </div>
                </div>
                <div className="col-md-8">
                  <p>{p.prodName}</p>
                  <p>{p.prodDesc.substring(0, 30)}</p>
                  <p>{'₹' + p.unitPrice}</p>
                  <button
                    className="btn btn-danger"
                    onClick={() => removeCartItem(p.id, p.prodName)}
                  >
                    Remove
                  </button>
                </div>
              </div>
            ))}
          </div>
          <div className="col-md-4 text-center">
            <h2>Cart Summary</h2>
            <p>Total | Checkout | Payment</p>
            <hr></hr>
            <h4>Total : {totalPrice()} </h4>
            <hr />
            <button
              className="btn btn-primary"
              onClick={() => navigate('/paymentpage')}
            >
              Make Payment
            </button>
          </div>
        </div>
      </div>
    </div>
  )
}

export default CardScreen
