import React, { useState, useEffect } from 'react'
import { Row, Col } from 'react-bootstrap'
import ProductScreen from '../ProductScreen'
import base_url from '../../api/bootapi'
import httpClient from '../../http-common'

const MachineriesScreen = () => {
  const [Products, setProducts] = useState([])

  useEffect(() => {
    const fetchAllProducts = async () => {
      const { data } = await httpClient.get(`${base_url}/api/prod/Machineries`)
      setProducts(data)
    }
    fetchAllProducts()
  }, [])

  return (
    <div>
      <h1>All Machineries and Tools</h1>
      <Row>
        {Products.map((Machine) => (
          <Col key={Machine.id} md={3}>
            <ProductScreen product={Machine} />
          </Col>
        ))}
      </Row>
    </div>
  )
}

export default MachineriesScreen
