import React, { useState, useEffect } from 'react'
import { Row, Col } from 'react-bootstrap'
import ProductScreen from './ProductScreen'
import base_url from '../api/bootapi'
import httpClient from '../http-common'
import Layout from '../components/Layout'

const FertilizerScreen = () => {
  const [Products, setProducts] = useState([])

  useEffect(() => {
    const fetchAllProducts = async () => {
      const { data } = await httpClient.get(`${base_url}/api/prod/Fertilizers`)
      setProducts(data)
    }
    fetchAllProducts()
  }, [])

  return (
    <div>
      <h1>All Fertilizers Products</h1>
      <Row>
        {Products.map((fertilizer) => (
          <Col key={fertilizer.id} md={3}>
            <ProductScreen product={fertilizer} />
          </Col>
        ))}
      </Row>
    </div>
  )
}

export default FertilizerScreen
