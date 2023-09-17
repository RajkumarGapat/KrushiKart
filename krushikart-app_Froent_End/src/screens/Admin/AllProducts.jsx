import React, { useState, useEffect } from 'react'
import AdminMenus from './AdminMenus'
import axios from 'axios'
import toast from 'react-hot-toast'
import { Link } from 'react-router-dom'
import base_url from '../../api/bootapi'
import httpClient from '../../http-common'
import { Card } from 'react-bootstrap'

const AllProducts = () => {
  const [products, setProducts] = useState([])

  //getall products
  const getAllProducts = async () => {
    try {
      const { data } = await httpClient.get(`${base_url}/api/prod`)
      setProducts(data)
    } catch (error) {
      console.log(error)
      toast.error('Someething Went Wrong')
    }
  }

  //lifecycle method
  useEffect(() => {
    getAllProducts()
  }, [])

  return (
    <div className="container-fluid m-3 p-3 dashboard">
      <div className="row">
        <div className="col-md-3">
          <AdminMenus />
        </div>
        <div className="col-md-9">
          {/* <h1>All Products</h1> */}
          <h1 className="text-center">All Products List</h1>
          <div className="d-flex flex-wrap">
            {products?.map((p) => (
              <Link
                key={p.id}
                to={`/api/prod/prod/${p.id}`}
                className="product-link"
              >
                <div className="card m-2" style={{ width: '18rem' }}>
                  <img
                    to={`/api/prod/prod/${p.id}`}
                    className="card-img-top"
                    alt={p.prodName}
                    src={p.imageUrl}
                  />
                  <div className="card-body">
                    <h5 className="card-title">{p.prodName}</h5>
                    <p className="card-text">{p.prodDesc}</p>
                  </div>
                </div>
              </Link>
            ))}
          </div>
        </div>
      </div>
    </div>
  )
}

export default AllProducts
